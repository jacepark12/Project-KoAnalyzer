import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by parkjaesung on 2016. 10. 26..
 */
public class TestMapping {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
