package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class SearchDataProvider {

    private static final SearchDataRegistry registry = new InMemorySearchDataRegistry(List.of(
            "Тестовый запрос",
            "Тест".repeat(100),
            " "
    ));

    public static Stream<Arguments> searchQueries() {
        return Stream.generate(() -> {
                    if (!registry.hasNext()) {
                        throw new IllegalStateException("Нет доступных данных для теста");
                    }
                    return Arguments.of(registry.next());
                })
                .limit(3);
    }
}
