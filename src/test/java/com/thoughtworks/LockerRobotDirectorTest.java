package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class LockerRobotDirectorTest {
    @Test
    void should_print_correct_report_when_print_report_given_LockerRobotDirect_manage_1_manager_manager_manage_2_robots() {
        Locker firstLocker = new Locker(1);
        firstLocker.storeBag(new Bag(""));
        PrimaryLockerRobot firstRobot = new PrimaryLockerRobot(Collections.singletonList(firstLocker));
        PrimaryLockerRobot secondRobot = new PrimaryLockerRobot(Collections.singletonList(new Locker(1)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager( Arrays.asList(firstRobot, secondRobot), Collections.emptyList());
        LockerRobotDirector director = new LockerRobotDirector(lockerRobotManager);

        String gotReport = director.printReport();

        String wantReport = "M 1 2\n" +
                "  R 0 1\n" +
                "    L 0 1\n" +
                "  R 1 1\n" +
                "    L 1 1\n";
        Assertions.assertEquals(wantReport, gotReport);
    }


    @Test
    void should_print_correct_report_when_print_report_given_LockerRobotDirect_manage_1_manager_and_manager_manage_one_robot_and_robot_manage_two_lockers() {
        Locker firstLocker = new Locker(1);
        firstLocker.storeBag(new Bag(""));
        Locker secondLocker = new Locker(1);
        PrimaryLockerRobot robot = new PrimaryLockerRobot(Arrays.asList(firstLocker, secondLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(Collections.singletonList(robot), Collections.emptyList());
        LockerRobotDirector director = new LockerRobotDirector(lockerRobotManager);

        String gotReport = director.printReport();

        String wantReport = "M 1 2\n" +
                "  R 1 2\n" +
                "    L 0 1\n" +
                "    L 1 1\n";
        Assertions.assertEquals(wantReport, gotReport);

    }
}
