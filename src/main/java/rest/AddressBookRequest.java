package rest;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookRequest {

    @NonNull
    String name;

    @NonNull
    String address;
}
