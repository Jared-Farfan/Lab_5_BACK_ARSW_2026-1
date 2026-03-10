package com.lab5.board.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.lab5.board.model.LineMessage;

@Controller
public class BoardController {

    /**
     * recive el mensaje del frontend en /app/draw y lo envia a todos los clientes
     * 
     * @param message
     * @return
     */
    @MessageMapping("/draw")
    @SendTo("/topic/board")
    public LineMessage handleDraw(LineMessage message) {
        message.setType("draw");
        return message;
    }

    /**
     * metodo para limpiar el tablero, recibe un mensaje del frontend en /app/clear y lo envia a todos los clientes
     * 
     * @return
     */
    @MessageMapping("/clear")
    @SendTo("/topic/board")
    public LineMessage handleClear(LineMessage message) {
        message.setType("clear");
        return message;
    }
}