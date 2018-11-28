import java.time.LocalDateTime;
import java.util.Date;

public interface DateInterval {

    Date getStart();

    Date getEnd();

    boolean isIntersected(DateIntervalImpl dateInterval);
}
