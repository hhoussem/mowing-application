package com.mowitnow.mowing;

import com.mowitnow.mowing.domain.*;
import com.mowitnow.mowing.infra.FileReader;

import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {

    public static final String MOWERS_INPUT_FILE_NAME = "mowitnow.txt";

    public static void main(String[] args) {
        String mowersInputFileName = MOWERS_INPUT_FILE_NAME;
        List<String> lines = new FileReader().readLines(mowersInputFileName);
        int nbLines = lines.size();
        if (nbLines == 1 || nbLines % 2 == 0) {
            throw new IllegalArgumentException("Bad File format" + mowersInputFileName);
        }
        Lawn lawn = createLawn(lines.get(0));
        // TODO: 13/02/2023  can be done with stream
        //  see  https://stackoverflow.com/questions/50977793/is-use-of-atomicinteger-for-indexing-in-stream-a-legit-way
        for (int i = 1; i < nbLines - 1; i = i + 2) {
            Mower mower = createMower(lines.get(i), lawn);
            List<Instruction> instructions = getInstructions(lines.get(i + 1));
            mower.execute(instructions);
            System.out.println(mower.value());
        }
    }

    private static List<Instruction> getInstructions(String s) {
        return s.chars().mapToObj(c -> Instruction.of((char) c)).toList();
    }

    private static Mower createMower(String line, Lawn lawn) {
        String[] split = line.split(" ");
        if (split.length != 3) {
            throw new RuntimeException();
        }
        Position position = new Position(parseInt(split[0]), parseInt(split[1]), lawn);
        if (split[2].length() != 1) {
            throw new RuntimeException();
        }
        return new Mower(position, Orientation.of(split[2].charAt(0)));
    }

    private static Lawn createLawn(String line) {
        String[] split = line.split(" ");
        if (split.length != 2) {
            throw new RuntimeException();
        }
        return new Lawn(parseInt(split[0]), parseInt(split[1]));
    }
}
