package com.fullstack.clubs.service;


import com.fullstack.clubs.entities.Participant;

public interface IGestionParticipant  {
    Participant addParticipant(Participant participant);
    Participant getPaticipantById(int id);
    Participant updateParticipant(Participant participant);
    void deleteParticipant(int id);
}
