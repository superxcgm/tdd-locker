# Locker（储物柜）

## Tasking
Given：locker有可用容量
When：存包
Then：返回票据


Given：locker已经存满
When：存包
Then：存包失败，提示储物柜已满


Given：一张有效票据
When：取包
Then：取到对应的包


Given：一张伪造票据
When：取包
Then：取包失败，提示非法票据


Given：一张重复使用的票据
When：取包
Then：取包失败，提示非法票据

## Tasking For Primary Locker Robot
Given：机器人管理两个储物柜，两个储物柜都有可用空间
When：存包
Then：存包成功，返回票据，包存入第一个储物柜

Given：机器人管理两个储物柜，第一个储物柜满了，但第二个储物柜有可用容量
When：存包
Then：存包成功，返回票据，包存入第二个储物柜

Given：机器人管理的储物柜全满了
When：存包
Then：存包失败，提示“储物柜已满”

Given：给机器人一张合法的票据
When：取包
Then：用户可以取到自己的包

Given：用户给机器人一张伪造的票据
When：取包
Then：取包失败，提示“票据不合法”

## Tasking For Smart Locker Robot
Given：SmartLockerRobot管理2个Locker，容量均为2。第一个Locker有2个空格，第二个Locker有1个空格
When：存包
Then：存包成功，返回票据，包被存入第一个Locker

Given：SmartLockerRobot管理2个Locker，容量均为2。第一个Locker有1个空格，第二个Locker有2个空格
When：存包
Then：存包成功，返回票据，包被存入第二个Locker

Given：SmartLockerRobot管理2个Locker，容量均为2。第一个Locker有1个空格，第二个Locker有1个空格
When：存包
Then：存包成功，返回票据，包被存入第一个Locker

Given：SmartLockerRobot管理2个Locker，两个Locker都存满了
When：存包
Then：存包失败，提示“储物柜已满”

Given：SmartLockerRobot管理2个Locker，给机器人一张合法的票据
When：取包
Then：取包成功，取到对应的包

Given：SmartLockerRobot管理2个Locker，给机器人一张伪造的票据
When：取包
Then：取包失败，提示“票据不合法”

Given：PrimaryLockerRobot和SmartLockerRobot共同管理2个Locker，通过PrimaryLockerRobot存入包，获得票据，给SmartLockerRobot这张票据
When：取包
Then：取包成功，取到对应的包

Given：PrimaryLockerRobot和SmartLockerRobot共同管理2个Locker，通过SmartLockerRobot存入包，获得票据，给PrimaryLockerRobot这张票据
When：取包
Then：取包成功，取到对应的包

## Tasking for robot manager

1.
Given：LockerRobotManager管理2个robot，自身没有locker，第一个robot管理的locker有剩余的空间
When：存包
Then：存包成功，包被存入第一个robot管理的locker里，返回票据

2.
Given：LockerRobotManager管理2个robot，自身没有locker，第一个robot管理的locker满了，第二个robot管理的locker有剩余的空间
When：存包
Then：存包成功，包被存入第二个robot管理的locker里，返回票据

3.
Given：LockerRobotManager管理2个robot，自身没有locker，两个robot管理的locker都满了
When：存包
Then：存包失败，提示“locker满了”

只有locker，没有robot的情况：

4.
Given：LockerRobotManager管理0个robot，自身有2个locker，第一个locker还没满
When：存包
Then：存包成功，包被存入第一个locker

5.
Given：LockerRobotManager管理0个robot，自身有2个locker，第一个locker满了，第二个locker没满
When：存包
Then：存包成功，包被存入第二个locker

6.
Given：LockerRobotManager管理0个robot，自身有2个locker，两个locker都满了
When：存包
Then：存包失败，提示“locker满了”

有robot，又有locker的情况：

7.
Given：LockerRobotManager管理1个robot，自身有1个locker，robot管理的locker还没满
When：存包
Then：存包成功，包被robot管理的locker中

8.
Given：LockerRobotManager管理1个robot，自身有1个locker，robot管理的locker满了，LockerRobotManager自身的locker还有剩余的空间
When：存包
Then：存包成功，包被存入LockerRobotManager自身的locker里

9.
Given：LockerRobotManager管理1个robot，自身有1个locker，robot管理的locker满了，LockerRobotManager自身的locker也满了
When：存包
Then：存包失败，提示“locker满了”


10.
Given：LockerRobotManager管理1个robot，自身没有locker，票据有效
When：取包
Then：取包成功，用户取到对应的包

11.
Given：LockerRobotManager管理1个robot，自身没有locker，票据无效
When：取包
Then：取包失败，提示“票据不合法”

12.
Given：LockerRobotManager管理0个robot，自身有1个locker，票据有效
When：取包
Then：取包成功，用户取到对应的包

13.
Given：LockerRobotManager管理0个robot，自身有1个locker，票据无效
When：取包
Then：取包失败，提示“票据不合法”

14.
Given：LockerRobotManager管理1个robot，自身有1个locker，票据有效
When：取包
Then：取包成功，用户取到对应的包

15.
Given：LockerRobotManager管理1个robot，自身有1个locker，票据无效
When：取包
Then：取包失败，提示“票据不合法”


## Tasking for Locker Robot Director
Given：LockerRobotDirector管理1个Manager，Manager管理2个robot, 第一个robot管理1个locker，可用容量为0，总容量为1。第二个robot管理1个locker，可用容量为1，总容量为1。
When：打印报表
Then：输出：
M 1 2
  R 0 1
    L 0 1
  R 1 1
    L 1 1

Given：LockerRobotDirector管理1个Manager，Manager管理1个robot, robot管理2个locker，第一个locker的可用容量为0，总容量为1。第二个locker的可用容量为1，总容量为1。
When：打印报表
Then：输出：
M 1 2
  R 0 2
    L 0 1
    L 1 1 

Given：LockerRobotDirector管理1个Manager，Manager管理2个locker，第一个locker的可用容量为0，总容量为1。第二个locker的可用容量为1，总容量为1。
When：打印报表
Then：输出：
M 1 2
  L 0 1
  L 1 1

Given：LockerRobotDirector管理1个Manager，Manager管理1个locker，1个robot，locker的可用容量为0，总容量为1，robot管理1个locker，可用容量为1，总容量为1。
When：打印报表
Then：输出：
M 1 2
  L 0 1
  R 1 1
  	L 1 1


Given：LockerRobotDirector管理2个Manager，第一个Manager管理一个locker，locker的可用容量为0，总容量为1，第二个Manager管理一个Locker，可用容量为1，总容量为1。
When：打印报表
Then： 输出
M 0 1
  L 0 1
M 1 1
  L 1 1

Given：有一个没有被LockerRobotDirector管理的locker
When：打印报表
Then： 输出的报表不包含这个locker

Given：有一个没有被LockerRobotDirector管理的robot
When：打印报表
Then： 输出的报表不包含这个robot