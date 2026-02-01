package problem.heap.priority;

import java.util.*;

public class Lc2402MostBooked {

    private int maxCount = 0;
    private int roomId = 0;
    private List<Room> pending;

    private static void addMessageQueue(int[][] meetings, int i,
                                        PriorityQueue<Meeting> meetingQueue) {
        Meeting meeting = new Meeting();
        meeting.index = i;
        meeting.start = meetings[i][0];
        meeting.duration = meetings[i][1] - meetings[i][0];
        meetingQueue.add(meeting);
    }

    private void updateRoom(PriorityQueue<Meeting> meetingQueue,
                            PriorityQueue<Room> roomQueue) {
        Meeting meetingHead = meetingQueue.poll();
        Room roomHead = roomQueue.poll();
        if (roomQueue.isEmpty() || roomQueue.peek().end > meetingHead.start) {
            roomHead.end = Math.max(roomHead.end, meetingHead.start) + meetingHead.duration;
            incrementRoomCount(roomHead);
            roomQueue.add(roomHead);
            return;
        }
        pending.add(roomHead);
        Room roomUse = roomHead;
        while (!roomQueue.isEmpty()) {
            Room room = roomQueue.peek();
            if (room.end > meetingHead.start) {
                break;
            }
            pending.add(room);
            roomQueue.poll();
            if (room.index < roomUse.index) {
                roomUse = room;
            }
        }
        roomUse.end = Math.max(roomUse.end, meetingHead.start) + meetingHead.duration;
        incrementRoomCount(roomUse);
        roomQueue.addAll(pending);
        pending.clear();
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(meeting -> meeting[0]));
        PriorityQueue<Room> roomQueue = new PriorityQueue<>(n);
        PriorityQueue<Meeting> meetingQueue = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            Room room = new Room();
            room.index = i;
            roomQueue.add(room);
        }
        pending = new ArrayList<>(n);
        for (int i = 0; i < meetings.length; i++) {
            Room roomHead = roomQueue.peek();
            addMessageQueue(meetings, i, meetingQueue);
            if (meetingQueue.size() < n && meetingQueue.peek().start < roomHead.end) {
                continue;
            }
            updateRoom(meetingQueue, roomQueue);
        }
        while (!meetingQueue.isEmpty()) {
            updateRoom(meetingQueue, roomQueue);
        }
        return roomId;
    }

    private void incrementRoomCount(Room roomHead) {
        int roomCount = ++roomHead.count;
        if (roomCount > maxCount) {
            maxCount = roomHead.count;
            roomId = roomHead.index;
        } else if (roomCount == maxCount) {
            roomId = Math.min(roomId, roomHead.index);
        }
    }

    private static class Room implements Comparable<Room> {

        int index;
        long end;
        int count;


        @Override
        public int compareTo(Room that) {
            if (this.end != that.end) {
                return this.end < that.end ? -1 : 1;
            }
            return this.index - that.index;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "index=" + index +
                    ", end=" + end +
                    ", count=" + count +
                    '}';
        }
    }

    private static class Meeting implements Comparable<Meeting> {

        int index;
        long start;
        long duration;


        @Override
        public int compareTo(Meeting that) {
            if (this.start != that.start) {
                return this.start < that.start ? -1 : 1;
            }
            return this.index - that.index;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "index=" + index +
                    ", start=" + start +
                    ", duration=" + duration +
                    '}';
        }
    }
}
