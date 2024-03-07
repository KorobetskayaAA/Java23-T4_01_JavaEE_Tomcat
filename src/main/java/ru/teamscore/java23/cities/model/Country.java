package ru.teamscore.java23.cities.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Country {
    @EqualsAndHashCode.Include
    @NonNull
    private String code;
    @NonNull
    private String name;
}
