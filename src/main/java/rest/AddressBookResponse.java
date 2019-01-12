package rest;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookResponse {

    @NonNull
    String name;

    @NonNull
    String address;
}
