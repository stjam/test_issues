import java.util.Date;
import java.util.Optional;

public final class DateIntervalImpl implements DateInterval {
    private final Date start;
    private final Date end;

    public DateIntervalImpl(final Date start, final Date end) throws IllegalArgumentException {
        this.start = Optional.ofNullable(start).orElseThrow(() -> new IllegalArgumentException("start date was null"));
        this.end = Optional.ofNullable(end).orElseThrow(() -> new IllegalArgumentException("end date was null"));
        if (start.after(end)) {
            throw new IllegalArgumentException(String.format("start date %s goes after end date %s", start, end));
        }
    }

    @Override
    public final Date getStart() {
        return new Date(start.getTime());
    }

    @Override
    public final Date getEnd() {
        return new Date(end.getTime());
    }

    @Override
    public final boolean isIntersected(final DateIntervalImpl dateInterval) {
        return this.start.getTime() <= dateInterval.end.getTime()
                && this.end.getTime() >= dateInterval.start.getTime();
    }


}
