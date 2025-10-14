class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Player player = new Player(timeToSeconds(video_len), timeToSeconds(pos), timeToSeconds(op_start), timeToSeconds(op_end));

            for (int i = 0; i < commands.length; i++) {
                String command = commands[i];
                if (command.equals("next")) {
                    player.next();
                } else if(command.equals("prev")) {
                    player.prev();
                }
            }


            System.out.println(player.getResult());

            return player.getResult();
    }
    
    public static int timeToSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
    
    class Player {
        int videoLength;
        int currentPosition;
        int openingStart;
        int openingEnd;

        public Player(int videoLength, int currentPosition, int openingStart, int openingEnd) {
            this.videoLength = videoLength;
            this.openingStart = openingStart;
            this.openingEnd = openingEnd;
            if(currentPosition >= openingStart && currentPosition <= openingEnd) {
                this.currentPosition = openingEnd;
            } else {
                this.currentPosition = currentPosition;
            }

        }

        public void next() {
            if (currentPosition + 10 >= videoLength) {
                currentPosition = videoLength;
            } else {
                currentPosition = currentPosition + 10;
            }

            if(currentPosition >= openingStart && currentPosition <= openingEnd) {
                this.currentPosition = openingEnd;
            }
        }

        public void prev() {
            if (currentPosition - 10 <= 0) {
                currentPosition = 0;
            } else {
                currentPosition = currentPosition - 10;
            }

            if(currentPosition >= openingStart && currentPosition <= openingEnd) {
                this.currentPosition = openingEnd;
            }
        }

        public String getResult() {
            return String.format("%02d:%02d", currentPosition / 60, currentPosition % 60);
        }

        @Override
        public String toString() {
            return "Player{" +
                    "videoLength=" + videoLength +
                    ", currentPosition=" + currentPosition +
                    ", openingStart=" + openingStart +
                    ", openingEnd=" + openingEnd +
                    '}';
        }
    }
    
    
}