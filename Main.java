import java.io.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) {
        Scanner input;
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            input = new Scanner(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        boolean done = false;

        while (!done) {
            String line = input.nextLine();
            System.out.println(line);
            if (line.isEmpty()) {
                done = true;
            } else {
                // lex this string, and pass it to the parser
                SlothLexer lexer = new SlothLexer(CharStreams.fromString(line));
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                SlothParser parser = new SlothParser(tokens);

                // do the parsing
                ParseTree tree = parser.expression();

                // visit the tree to execute it
                SlothVisitor visitor = new SlothVisitor();
                SlothValue result = visitor.visit(tree);
                // System.out.println(result);
            }
        }
    }
}