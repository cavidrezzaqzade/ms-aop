package az.ingress.msaop.model;

import lombok.*;

/**
 * @author caci
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria {
    private Long id;
    private String name;
    private Short age;
}
