package com.daniel.softmanager.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
