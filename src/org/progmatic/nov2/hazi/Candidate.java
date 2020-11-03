package org.progmatic.nov2.hazi;

public class Candidate {
    private final int constituency;
    private final int votes;
    private final String lastName;
    private final String firstName;
    private final String party;

    public Candidate(int constituency, int votes, String lastName, String firstName, String party) {
        this.constituency = constituency;
        this.votes = votes;
        this.lastName = lastName;
        this.firstName = firstName;
        this.party = party;
    }

    public int getConstituency() {
        return constituency;
    }

    public int getVotes() {
        return votes;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getParty() {
        return party;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "constituency=" + constituency +
                ", votes=" + votes +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", party='" + party + '\'' +
                '}';
    }
}
