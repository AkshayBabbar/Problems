package src.scaler.ooad.interfaceImpl;

public class StackDemo {
    public static void main(String[] args) {
        // Test ArrayStack
        System.out.println("Testing ArrayStack:");
        StackInterface<Integer> arrayStack = new ArrayStack<>();
        testStack(arrayStack);
        
        // Test stack growth
        System.out.println("\nTesting ArrayStack capacity growth:");
        ArrayStack<Integer> growingStack = new ArrayStack<>(2);
        System.out.println("Initial capacity: " + growingStack.getCapacity());
        for (int i = 1; i <= 5; i++) {
            growingStack.push(i);
        }
        System.out.println("After pushing 5 elements, capacity: " + growingStack.getCapacity());
        
        // Test LinkedListStack
        System.out.println("\nTesting LinkedListStack:");
        StackInterface<Integer> linkedListStack = new LinkedListStack<>();
        testStack(linkedListStack);
    }
    
    /**
     * Helper method to test a stack implementation.
     * 
     * @param stack the stack to test
     */
    private static void testStack(StackInterface<Integer> stack) {
        System.out.println("Is stack empty? " + stack.isEmpty());
        
        // Push elements
        System.out.println("Pushing elements 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        
        // Pop elements
        System.out.println("Popping all elements:");
        
        System.out.println("Is stack empty now? " + stack.isEmpty());
        
        // Try to peek on empty stack
        try {
            stack.peek();
        } catch (EmptyStackException e) {
            System.out.println("Exception correctly thrown: " + e.getMessage());
        }
        
        // Add more elements and then clear
        System.out.println("Pushing elements 40, 50");
        stack.push(40);
        stack.push(50);
        System.out.println("Stack size before clear: " + stack.size());
        System.out.println("Stack size after clear: " + stack.size());
    }
}