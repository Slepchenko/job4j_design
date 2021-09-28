package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "onBoardNum")
public class OnBoard {

    @XmlAttribute
    private String number;

    public OnBoard() {

    }

    public OnBoard(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "OnBoard{"
                + "number='" + number + '\''
                + '}';
    }
}
