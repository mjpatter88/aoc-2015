import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    private static final String FILENAME = "input.txt";

    private static final HashMap<Location, Integer> visits = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get(FILENAME)));

        System.out.println(solve1(input));
        visits.clear();
        System.out.println(solve2(input));
    }
    private static int solve1(String input) {
        int currentX = 0;
        int currentY = 0;
        visit(currentX, currentY);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '^':
                    currentY += 1;
                    break;
                case '>':
                    currentX += 1;
                    break;
                case 'v':
                    currentY -= 1;
                    break;
                case '<':
                    currentX -= 1;
                    break;
                default:
                    throw new RuntimeException("Unexpected character: " + c);
            }
            visit(currentX, currentY);
        }
        return visits.size();
    }

    private static int solve2(String input) {
        int currentX = 0;
        int currentY = 0;
        int secondX = 0;
        int secondY = 0;
        boolean isFirst = true;
        visit(currentX, currentY);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '^':
                    if(isFirst) {
                        currentY += 1;
                    } else {
                        secondY += 1;
                    }
                    break;
                case '>':
                    if(isFirst) {
                        currentX += 1;
                    } else {
                        secondX += 1;
                    }
                    break;
                case 'v':
                    if(isFirst) {
                        currentY -= 1;
                    } else {
                        secondY -= 1;
                    }
                    break;
                case '<':
                    if(isFirst) {
                        currentX -= 1;
                    } else {
                        secondX -= 1;
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected character: " + c);
            }
            if(isFirst) {
                visit(currentX, currentY);
            } else {
                visit(secondX, secondY);
            }
            isFirst = !isFirst;
        }
        return visits.size();
    }

    private static void visit(int x, int y) {
        Location location = new Location(x, y);
        if (visits.containsKey(location)) {
            Integer num = visits.get(location);
            visits.put(location, num + 1);
        } else {
            visits.put(location, 1);
        }
    }

    private static class Location {
        private final int x;
        private final int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Location)) {
                return false;
            }
            Location other = (Location) obj;
            return other.x == this.x && other.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }
}