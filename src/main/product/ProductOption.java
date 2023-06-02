package main.product;

import java.util.Arrays;
import java.util.List;

// 옵션 객체
public class ProductOption {
    private List<String> options;

    public ProductOption(String... options){
        this.options = Arrays.asList(options);
    }

    public List<String> getOptions(){
        return options;
    }
}
