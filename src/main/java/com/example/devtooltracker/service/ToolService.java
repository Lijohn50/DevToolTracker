package com.example.devtooltracker.service;

import com.example.devtooltracker.model.Tool;
import com.example.devtooltracker.repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolService {

    private final ToolRepository toolRepository;

    public void addTool(Tool tool) {

        toolRepository.save(tool);
    }
    public void deleteTool(int id){


    }
    public List<Tool> findAll(){

        return toolRepository.findAll();
    }
}
