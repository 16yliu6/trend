package cn.how2j.controller;

import cn.how2j.pojo.Index;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class IndexController {



    public List<Index> fresh() {
        return Collections.EMPTY_LIST;
    }

    public List<Index> get() {
        return Collections.EMPTY_LIST;
    }

    public String remove() {
        return "ok";
    }
}
