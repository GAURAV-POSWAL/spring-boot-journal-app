package com.teamSpring.JournalApplication.controller;

import com.teamSpring.JournalApplication.entities.Journal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("journal")
public class JournalController {

    private final Map<Long, Journal> journalEntries = new HashMap<>();

    @GetMapping
    public List<Journal> getAllEntries() {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("id/{id}")
    public Journal getJournalById(@PathVariable Long id) {
        return journalEntries.get(id);
    }

    @DeleteMapping("id/{id}")
    public Journal removeJournalById(@PathVariable Long id) {
        return journalEntries.remove(id);
    }

    @PostMapping
    public boolean addJournal(@RequestBody Journal entry) {
        journalEntries.put(entry.getId(), entry);
        return true;
    }

    @PutMapping("id/{id}")
    public boolean updateJournal(@PathVariable Long id,  @RequestBody Journal entry) {
        journalEntries.put(id, entry);
        return true;
    }

}
