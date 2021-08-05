package by.du.todo.model;

import by.du.todo.controller.FormatService;

import java.time.LocalDateTime;

public class Meeting implements Event {

    private int id;
    private String place;
    private LocalDateTime start;
    private LocalDateTime end;
    private String desc;

    public Meeting() {
    }

    public Meeting(int id, String place, LocalDateTime start, LocalDateTime end, String desc) {
        this.id = id;
        this.place = place;
        this.start = start;
        this.end = end;
        this.desc = desc;
    }

    public Meeting(String place, LocalDateTime start, LocalDateTime end, String desc) {
        this.place = place;
        this.start = start;
        this.end = end;
        this.desc = desc;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Meeting meeting = (Meeting) o;

        if (id != meeting.id) return false;
        if (place != null ? !place.equals(meeting.place) : meeting.place != null) return false;
        if (start != null ? !start.equals(meeting.start) : meeting.start != null) return false;
        if (end != null ? !end.equals(meeting.end) : meeting.end != null) return false;
        return desc != null ? desc.equals(meeting.desc) : meeting.desc == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + "," + place + "," + FormatService.localeDate(start) + "," + FormatService.localeDate(end) + "," + desc;
    }
}
