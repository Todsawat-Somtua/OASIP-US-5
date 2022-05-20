package sit.int221.oasipus5backend.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    @NotNull(message = "Category is empty, Insert category")
    private Integer eventCategoryId;
    @NotBlank(message = "Your name is Blank, Please insert your name")
    @NotEmpty(message = "Your name is Empty, Please insert your name")
    @Size(max = 100, message = "Max character of the name is 100 characters")
    private String bookingName;
    @NotEmpty(message = "Your email is Empty, Please insert your email")
    @Email(message = "Your email is invalid, Please insert in the form email@address.com")
    @Size(max = 100, message = "Max character of the email is 100 characters")
    private String bookingEmail;
    @NotNull(message = "Time is empty, Insert time")
    @Future(message = "Your Time is invalid, Please insert a future date and time")
    private Instant eventStartTime;
    @Size(max = 500, message = "Note must size between 0 and 500 character")
    private String eventNotes;
}
