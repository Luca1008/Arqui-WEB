package main.monopatines.servicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import lombok.var;

@Service("MonopatinServicio")
public class MonopatinServicio {

    @Autowired
    private MonopatinRepository MonopatinRepository;
}