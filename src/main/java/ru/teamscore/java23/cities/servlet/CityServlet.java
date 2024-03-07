package ru.teamscore.java23.cities.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.teamscore.java23.cities.model.City;
import ru.teamscore.java23.cities.model.Country;
import ru.teamscore.java23.cities.service.CityService;

import java.io.IOException;
import java.util.Optional;


@WebServlet("/city/*")
public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CityService service;

    public void init() {
        System.out.println("HelloServlet on init");
        service = new CityService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getPathInfo();

        try {
            switch (action) {
                case "/create":
                    createCity(request, response);
                    break;
                case "/update":
                    updateCity(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getPathInfo();
        try {
            if (action == null) {
                home(request, response);
                return;
            }
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/delete":
                    deleteCity(request, response);
                    break;
                default:
                    home(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        City[] cities = service.getAllCities();
        request.setAttribute("cities", cities);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/cities/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("countries", service.getAvaliableCountries());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/cities/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("city_name");
        Optional<City> city = service.getCity(name);
        if (city.isPresent()) {
            request.setAttribute("city", city.get());
            request.setAttribute("countries", service.getAvaliableCountries());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/cities/edit.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void createCity(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String countryCode = request.getParameter("country");
        int population = Integer.parseInt(request.getParameter("population"));
        double lat = Double.parseDouble(request.getParameter("lat"));
        double lon = Double.parseDouble(request.getParameter("lon"));
        Optional<Country> country = service.getCountry(countryCode);
        if (country.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        service.create(new City(name, country.get(), population, lat, lon));
        response.sendRedirect("/city");
    }

    private void updateCity(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String countryCode = request.getParameter("country");
        int population = Integer.parseInt(request.getParameter("population"));
        double lat = Double.parseDouble(request.getParameter("lat"));
        double lon = Double.parseDouble(request.getParameter("lon"));
        Optional<Country> country = service.getCountry(countryCode);
        if (country.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        service.update(new City(name, country.get(), population, lat, lon));
        response.sendRedirect("/city");
    }

    private void deleteCity(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("city_name");
        service.delete(name);
        response.sendRedirect("/city");
    }
}
