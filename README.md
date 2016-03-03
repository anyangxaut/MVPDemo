标签：Android and MVP

MVP = Model + View + Presenter 
 
MVP是MVC模式的演化版本，由于UI和业务逻辑都是比较容易发生变化的，为了使得APP具有较大的弹性，我们希望可以将UI，业务逻辑和数据隔离开来，
 而MVP就是一个很好的选择。
 
MVC in Android：View对应layout布局文件，Model对应业务逻辑和实体模型，Controller对应Activity。
其中View所对应的layout布局文件能做的事情特别少，对于大多数例如数据绑定的操作和事件处理的代码都在Activity中，
因此造成Activity既像是View又像是Controller。（感觉只有View和Model层似得，一切操作都与Activity相关）

MVP in Android：View对应Activity，负责View的绘制以及与用户交互，Model依旧是业务逻辑和实体模型，Presenter负责完成View
与Model间的交互。

MVC与MVP：MVP减少了Activity的事务处理，简化了Activity中的代码，将复杂逻辑代码迁移到了Presenter中进行处理，实现了View与Model的解耦。