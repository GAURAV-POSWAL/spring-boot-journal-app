package com.teamSpring.JournalApplication.service;

import com.teamSpring.JournalApplication.entities.Journal;
import com.teamSpring.JournalApplication.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository repository;

    public void addJournal(Journal entry) {
        repository.save(entry);
    }

    public List<Journal> getJournals() {
        return repository.findAll();
    }

    public Optional<Journal> getJournalById(ObjectId id) {
        return repository.findById(id);
    }

    public void removeJournalById(ObjectId id) {
        repository.deleteById(id);
    }
}
