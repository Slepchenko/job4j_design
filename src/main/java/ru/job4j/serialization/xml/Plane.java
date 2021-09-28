package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "plane")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plane {

    @XmlAttribute
    private boolean warplane;

    @XmlAttribute
    private int age;
    private OnBoard onBoardNum;
    private String[] data;

    public Plane() {
    }

    public Plane(boolean warplane, int age, OnBoard onBoardNum, String[] data) {
        this.warplane = warplane;
        this.age = age;
        this.onBoardNum = onBoardNum;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Plane{"
                + "warplane=" + warplane
                + ", age=" + age
                + ", onBoardNum=" + onBoardNum
                + ", data=" + Arrays.toString(data)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Plane plane = new Plane(false, 5, new OnBoard("VQ-BDU"),
                new String[]{"Passenger", "Russian"});
        String result = "";
        JAXBContext context = JAXBContext.newInstance(Plane.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(plane, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            Plane res = (Plane) unmarshaller.unmarshal(reader);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
