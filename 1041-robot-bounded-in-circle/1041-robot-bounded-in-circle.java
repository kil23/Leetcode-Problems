class Solution {
    public boolean isRobotBounded(String instructions) {
        // if(instructions.length() == 0)
        //     return false;
        
        // int x = 0, y = 0;
        // String dir = "North";

        // for(char ch : instructions.toCharArray()) {
        //     if(ch == 'G') {
        //         if(dir.equals("North"))
        //             y += 1;
        //         else if(dir.equals("East"))
        //             x += 1;
        //         else if(dir.equals("South"))
        //             y -= 1;
        //         else
        //             x -=1;
        //     }
        //     else if(ch == 'L') {
        //         if(dir.equals("North"))
        //             dir = "West";
        //         else if(dir.equals("West"))
        //             dir = "South";
        //         else if(dir.equals("South"))
        //             dir = "East";
        //         else
        //             dir = "North";
        //     }
        //     else {
        //         if(dir.equals("North"))
        //             dir = "East";
        //         else if(dir.equals("East"))
        //             dir = "South";
        //         else if(dir.equals("South"))
        //             dir = "West";
        //         else
        //             dir = "North";
        //     }
        // }
            
        // if(x==0 && y==0)
        //     return true;
        // if(dir.equals("North"))
        //     return false;
        // return true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0;
        int dir = 0;

        for(char instr : instructions.toCharArray()) {
            if(instr == 'G') {
                x += dx[dir];
                y += dy[dir];
            } else if(instr == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        return (x == 0 && y == 0) || (dir != 0);
    }
}