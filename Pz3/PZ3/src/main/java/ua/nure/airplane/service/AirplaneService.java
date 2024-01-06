package ua.nure.airplane.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import ua.nure.airplane.dao.DAOException;
import ua.nure.airplane.entity.Airplane;
import ua.nure.airplane.entity.Ticket;

import java.util.Collection;

@WebService(targetNamespace= Const.SERVICE_NS)
    public interface AirplaneService {
    @WebMethod()
    @WebResult(targetNamespace="http://nure.ua/entity")
    public int addAirplane(
            @WebParam(name="Airplane", targetNamespace="http://nure.ua/entity")
            Airplane airplane) throws DAOException;

    @WebMethod()
    public void addTicket(
            @WebParam(name = "airplaneId")
            int airplaneId,
            @WebParam(name="Ticket", targetNamespace="http://nure.ua/entity")
            Ticket ticket) throws DAOException;

    @WebMethod()
    @WebResult(name="listAirplanes", targetNamespace="http://nure.ua/entity")
    public Collection<Airplane> listAirplanes();

    @WebMethod()
    @WebResult(name = "Ticket", targetNamespace = "http://nure.ua/entity")
    public Ticket getTicket(
            @WebParam(name="ticketNumber")
            String ticketNumber);

    @WebMethod()
    public void removeAirplane(
            @WebParam(name="airplaneId")
            int airplaneId) throws DAOException;
}