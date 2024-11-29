public class CLIHelper {
    public static void printHelp() {
        System.out.println("Uso: taskt-cli <comando> <parâmetros>");
        System.out.println("Comandos disponíveis:");
        System.out.println();
        System.out.println("add <descrição> | Adiciona uma nova tarefa.");
        System.out.println("list | Lista todas as tarefas.");
        System.out.println("list <status> | Lista tarefas com um status específico.");
        System.out.println("<status>: TODO, IN_PROGRESS, DONE");
        System.out.println("delete <id> | Remove uma tarefa pelo ID.");
        System.out.println("mark <id> <status> | Atualiza o status de uma tarefa.");
        System.out.println("<status>: TODO, IN_PROGRESS, DONE");
        System.out.println("update <id> <nova descrição> | Atualiza a descrição de uma tarefa.");
        System.out.println();
        System.out.println("Exemplos:");
        System.out.println("taskt-cli add \"Comprar leite\"");
        System.out.println("taskt-cli list");
        System.out.println("taskt-cli delete 1");
        System.out.println("taskt-cli mark 1 DONE");
        System.out.println("taskt-cli update 1 \"Comprar leite e ovos\"");
    }
}
