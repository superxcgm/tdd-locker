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