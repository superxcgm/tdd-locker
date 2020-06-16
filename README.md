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

## Tasking For Robot
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