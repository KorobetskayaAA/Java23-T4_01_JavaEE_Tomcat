package ru.teamscore.java23.cities.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City {
    @EqualsAndHashCode.Include
    @NonNull
    private String name;
    @NonNull
    private Country country;
    @NonNull
    private long population;
    @NonNull
    private double lat;
    @NonNull
    private double lon;
}
