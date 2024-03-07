package ru.teamscore.java23.cities.service;

import ru.teamscore.java23.cities.model.City;
import ru.teamscore.java23.cities.model.Country;

import java.util.*;

public class CityService {
    private static final Country ru = new Country("RU", "Россия");
    private static final Country cn = new Country("CN", "Китай");
    private static final Country us = new Country("US", "США");
    private static final Country it = new Country("IT", "Италия");
    private static final Country de = new Country("DE", "Германия");
    private static final Country eg = new Country("EG", "Египет");
    private static final List<Country> countries = new ArrayList<>(Arrays.asList(
            ru, cn, us, it, de, eg
    ));
    private List<City> cities = new ArrayList<>(Arrays.asList(
            new City("Самара", ru, 1_163_645 , 53.20007, 50.15),
            new City("Уфа", ru, 1_157_994, 54.7750, 56.0375),
            new City("Калуга", ru, 340_851,54.5358, 36.2706),
            new City("Комсомольск-на-Амуре", ru, 275_908, 50.5556, 137.0000),
            new City("Нижний Новгород", ru, 1_213_477, 56.2965, 43.93606),
            new City("Иркутск", ru, 611_215, 52.28697, 104.30502),
            new City("Пекин", cn, 11_106_000, 39.9289, 116.3883),
            new City("Шанхай", cn, 24_870_895, 31.2222, 121.458),
            new City("Нью-Йорк", us, 19_354_922,40.6943, -73.9249),
            new City("Канзас-сити", us, 156_607, 39.1239, -94.5541),
            new City("Рим", it, 2_748_109, 41.8919, 12.5113),
            new City("Венеция", it, 250_369, 45.433, 12.317),
            new City("Милан", it, 1_354_196,45.4654219, 9.1859243),
            new City("Берлин", de, 3_755_251,52.52001, 13.40495),
            new City("Гамбург", de, 1_814_879, 53.5753, 10.0153)
    ));

    public Optional<City> getCity(String name) {
        return cities
                .stream()
                .filter(c -> name.equals(c.getName()))
                .findFirst();
    }

    public City[] getAllCities() {
        return cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .toArray(City[]::new);
    }

    public City[] getCitiesOfCountry(Country country) {
        return cities.stream()
                .filter(c -> country.equals(c.getCountry()))
                .sorted(Comparator.comparing(City::getName))
                .toArray(City[]::new);
    }

    public Country[] getAvaliableCountries() {
        return countries.stream()
                .sorted(Comparator.comparing(Country::getName))
                .toArray(Country[]::new);
    }

    public Optional<Country> getCountry(String code) {
        return countries
                .stream()
                .filter(c -> code.equals(c.getCode()))
                .findFirst();
    }

    public void create(City city) {
        cities.add(city);
    }

    public void update(City city) {
        int index = cities.indexOf(city);
        if (index >= 0) {
            cities.set(index, city);
        }
    }

    public void delete(City city) {
        cities.remove(city);
    }

    public void delete(String name) {
        var cityOptional = getCity(name);
        if (cityOptional.isPresent()) {
            cities.remove(cityOptional.get());
        }
    }
}
