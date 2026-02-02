# kaplan-assignment
▶️Overview:
This test suite validates session persistence and cart synchronization across two concurrent browser sessions using the same OpenCart account. It ensures that updates in one browser are reflected in real-time in the other.

▶️ How to Run the Tests:
Prerequisites:
->Java 11+
->Maven installed
->Internet connection 

Steps:
Open the project in your IDE (e.g., IntelliJ or Eclipse)
Locate the testng.xml file in the project root
Right-click the testNg.xml → Run
Tests will execute in parallel according to the configuration in testng.xml
Screenshots of any failures are automatically saved in /screenshots
Console logs show real-time communication between Scenario A and Scenario B

🔄 Parallel Synchronization:
Synchronization between Scenario A and Scenario B is handled using a thread-safe signaling mechanism (CountDownLatch). Scenario A waits until Scenario B deletes an item from the cart before continuing its validation. This ensures real-time verification without hardcoded waits and guarantees that both scenarios interact reliably with the same account.
Refer file - SyncManager.java in utils package

🧵 Independent WebDriver Instances:
Each test scenario runs with its own ThreadLocal WebDriver instance, ensuring complete isolation between browser sessions. This prevents interference between parallel tests and allows safe, independent execution of multiple browsers simultaneously.
