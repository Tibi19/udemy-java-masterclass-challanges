package com.javamc;

import java.io.IOException;
import java.util.ArrayList;

public interface ISaveable {

    void save() throws IOException;
    void load() throws IOException;

}
