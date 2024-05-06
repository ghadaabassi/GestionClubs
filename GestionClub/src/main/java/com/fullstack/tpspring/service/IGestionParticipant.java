package com.fullstack.tpspring.service;


import com.fullstack.tpspring.entities.Participant;

public interface IGestionParticipant  {
    Participant addParticipant(Participant participant);
    Participant getPaticipantById(int id);
    Participant updateParticipant(Participant participant);
    void deleteParticipant(int id);
}
