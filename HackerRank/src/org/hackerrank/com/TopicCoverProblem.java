package org.hackerrank.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopicCoverProblem {

	public static void main(String[] args) {
		String[] topics = { "10101", "11110", "00010" };
		List<Integer> output = acmTeam(Arrays.asList(topics));
		System.out.println("Maximum number of known topics: " + output.get(0));
		System.out.println("Number of teams that knows maximum number of topics: " + output.get(1));

	}

	public static List<Integer> acmTeam(List<String> topic) {
		// Write your code here
		int numberOfTeam = topic.size();
		int pairOfTeamsKnowsMaxTopics = 0;
		int maxNumberOfTopicsKnownByTeamPair = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberOfTeam - 1; i++) {
			for (int j = i + 1; j < numberOfTeam; j++) {
				String firstTeam = topic.get(i);
				String secondTeam = topic.get(j);
				int numberOfTopicsKnown = getBitCount(firstTeam, secondTeam);
				if (numberOfTopicsKnown > maxNumberOfTopicsKnownByTeamPair) {
					maxNumberOfTopicsKnownByTeamPair=numberOfTopicsKnown;
					pairOfTeamsKnowsMaxTopics = 1;
				} else if (numberOfTopicsKnown == maxNumberOfTopicsKnownByTeamPair) {
					pairOfTeamsKnowsMaxTopics++;
				}
			}

		}
		list.add(maxNumberOfTopicsKnownByTeamPair);
		list.add(pairOfTeamsKnowsMaxTopics);
		return list;
	}

	private static int getBitCount(String firstTeam, String secondTeam) {
		char[] firstTeamtopicsArray = firstTeam.toCharArray();
		char[] secondTeamtopicsArray = secondTeam.toCharArray();
		int numberOfSubjectsKnownByTwoTeamsCount = 0;
		for (int i = 0; i < firstTeamtopicsArray.length; i++) {
			// below statement will return 1 if any of the value or both the value will
			// contain 1
			int isTopicKnown = Integer.valueOf(String.valueOf(firstTeamtopicsArray[i]))|Integer.valueOf(String.valueOf(secondTeamtopicsArray[i]));
			if (isTopicKnown == 1) {
				numberOfSubjectsKnownByTwoTeamsCount++;
			}
		}
		return numberOfSubjectsKnownByTwoTeamsCount;
	}

}
