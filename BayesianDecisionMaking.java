import java.util.Scanner;

public class BayesianDecisionMaking {

    // Calculate the posterior probability using Bayes' theorem
    public static double calculatePosterior(double prior, double likelihood, double evidence) {
        return (prior * likelihood) / evidence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prior probabilities
        System.out.println("Enter the prior probability of event A:");
        double priorA = scanner.nextDouble();

        System.out.println("Enter the prior probability of event B:");
        double priorB = scanner.nextDouble();

        // Likelihoods
        System.out.println("Enter the likelihood of event A given evidence:");
        double likelihoodA = scanner.nextDouble();

        System.out.println("Enter the likelihood of event B given evidence:");
        double likelihoodB = scanner.nextDouble();

        // Evidence (normalizing constant)
        double evidence = (priorA * likelihoodA) + (priorB * likelihoodB);

        // Posterior probabilities
        double posteriorA = calculatePosterior(priorA, likelihoodA, evidence);
        double posteriorB = calculatePosterior(priorB, likelihoodB, evidence);

        // Decision making
        if (posteriorA > posteriorB) {
            System.out.println("Decision: Event A is more likely to occur.");
        } else if (posteriorB > posteriorA) {
            System.out.println("Decision: Event B is more likely to occur.");
        } else {
            System.out.println("Both events are equally likely to occur.");
        }

        scanner.close();
    }
}
