package az.ingress.msaop.service.qualifier;

import org.springframework.stereotype.Service;

//@Primary //default bean when nothing is set
@Service
public class Excel implements Document{
    @Override
    public void print() {
        System.out.println("test.xls");
    }
}
