package org.example.exfinal.controller;

import org.example.exfinal.entity.Juegos;
import org.example.exfinal.entity.Editoras;
import org.example.exfinal.entity.Generos;
import org.example.exfinal.entity.Distribuidoras;
import org.example.exfinal.entity.Pais;
import org.example.exfinal.entity.Plataformas;
import jakarta.servlet.http.HttpServletRequest;
import org.example.exfinal.repository.JuegosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class JuegosController {

    final JuegosRepository JuegosRepository;
    private final JuegosRepository juegosRepository;

    public JuegosController(JuegosRepository JuegosRepository, JuegosRepository juegosRepository) {
        this.JuegosRepository = JuegosRepository;
        this.juegosRepository = juegosRepository;
    }


    @GetMapping(value = {"/list",""})
    public List<Juegos> list() {
        return JuegosRepository.findAll();
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<HashMap<String, Object>> create(
            @RequestBody Juegos Juego,
            @RequestParam(value = "fetchId",required = false) boolean fetchId) {

        HashMap<String, Object> responseMap = new HashMap<>();

        juegosRepository.save(Juego);

        if (fetchId) {
            responseMap.put("id", Juego.getIdjuego());

        }
        responseMap.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String >> gestionException(HttpServletRequest request) {

        HashMap<String, String> responseMap = new HashMap<>();
        if(request.getMethod().equals("POST")) {
            responseMap.put("estado", "error");
            responseMap.put("mensaje", "parámetros incorrectos");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }




    @PutMapping(value = {"actualizar"}, consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HashMap<String, Object>> update(@RequestBody Juegos juegoRecibido) {

        HashMap<String, Object> responseMap = new HashMap<>();

        if(juegoRecibido.getIdjuego() != null && juegoRecibido.getIdjuego() > 0 ) {

            Optional<Juegos> byId = juegosRepository.findById(juegoRecibido.getIdjuego());
            if(byId.isPresent()) {

                Juegos juegoFromDb = byId.get();

                if(juegoRecibido.getNombre() != null)
                    juegoFromDb.setNombre(juegoRecibido.getNombre());

                if(juegoRecibido.getDescripcion() != null)
                    juegoFromDb.setDescripcion(juegoRecibido.getDescripcion());

                if(juegoRecibido.getPrecio() != null)
                    juegoFromDb.setPrecio(juegoRecibido.getPrecio());

                if(juegoRecibido.getImage() != null)
                    juegoFromDb.setImage(juegoRecibido.getImage());

                if(juegoRecibido.getGenero() != null)
                    juegoFromDb.setGenero(juegoRecibido.getGenero());

                if (juegoRecibido.getPlataforma() != null)
                    juegoFromDb.setPlataforma(juegoRecibido.getPlataforma());

                if(juegoRecibido.getEditora() != null)
                    juegoFromDb.setEditora(juegoRecibido.getEditora());

                if(juegoRecibido.getDistibuidora() != null)
                    juegoFromDb.setDistibuidora(juegoRecibido.getDistibuidora());

                juegosRepository.save(juegoFromDb);
                responseMap.put("resultado", "actualizado");
                return ResponseEntity.status(HttpStatus.OK).body(responseMap);
            } else {
                responseMap.put("resultado", "error");
                responseMap.put("mensaje", "parámetros incorrectos");
                return ResponseEntity.badRequest().body(responseMap);
            }

        } else {
            responseMap.put("resultado", "error");
            responseMap.put("mensaje", "Debe enviar un juego con id");
            return ResponseEntity.badRequest().body(responseMap);
        }
    }
}
