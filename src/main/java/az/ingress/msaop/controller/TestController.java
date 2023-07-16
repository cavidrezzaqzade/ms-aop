package az.ingress.msaop.controller;

import az.ingress.msaop.service.qualifier.Document;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author caci
 */

@RestController
@RequestMapping("/v1/test")
@RequiredArgsConstructor
@Tag(name = "Test", description = "the Test Qualifier api")
public class TestController {

    private final Document pdf;//it works because there is a bean is called as 'pdf'

//    public TestController(@Qualifier("pdf") Document document) {
//        this.document = document;
//    }

    @GetMapping("/test-qualifier")
    @Operation(summary = "test qualifier", description = "test qualifier", tags = {"Test"})
    public void testQualifier(){
        pdf.print();
    }

}
