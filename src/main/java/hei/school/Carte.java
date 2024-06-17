package hei.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Carte {
    private final List<Lieux> lieux;
}
