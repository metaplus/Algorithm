package problem.array;

public class Lc844BackspaceCompare {

    public boolean backspaceCompare(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Cursor cursorS = new Cursor(charsS.length - 1, 0);
        Cursor cursorT = new Cursor(charsT.length - 1, 0);
        cursorS.skipBack(charsS);
        cursorT.skipBack(charsT);
        while (cursorS.id >= 0 && cursorT.id >= 0) {
            if (charsS[cursorS.id] != charsT[cursorT.id]) {
                return false;
            }
            cursorS.id--;
            cursorT.id--;
            cursorS.skipBack(charsS);
            cursorT.skipBack(charsT);
        }
        return cursorS.id < 0 && cursorT.id < 0;
    }

    class Cursor {

        int id;
        int skip;

        public Cursor(int id, int skip) {
            this.id = id;
            this.skip = skip;
        }

        void skipBack(char[] chars) {
            while ((id >= 0 && chars[id] == '#') || skip > 0) {
                if (id >= 0 && chars[id] == '#') {
                    skip++;
                    id--;
                    continue;
                }
                skip--;
                id--;
            }
        }
    }
}
