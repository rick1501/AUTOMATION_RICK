
# YourStore Automation

Automatización de flujos críticos para la tienda **Your Store** usando:
- **Java 11**
- **Serenity BDD + Screenplay**
- **Cucumber (Gherkin)**
- **Gradle Wrapper**

## Estructura
- `src/main/java/com/yourstore/automation/ui` → Page Objects (Targets)
- `src/main/java/com/yourstore/automation/tasks` → Tareas de Screenplay
- `src/main/java/com/yourstore/automation/questions` → Questions (validaciones)
- `src/test/resources/features` → Features en Gherkin
- `src/test/java/com/yourstore/automation/runners` → Runners
- `src/test/java/com/yourstore/automation/stepdefinitions` → Step definitions

## Ejecución
```bash
./gradlew clean test
```
El reporte se genera en `target/site/serenity`.
