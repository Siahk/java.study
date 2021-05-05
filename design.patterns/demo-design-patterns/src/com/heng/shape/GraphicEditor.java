package com.heng.shape;

public class GraphicEditor {
    public void drawShape(Shape shape) {
        if(shape.getMType() == 1) {
            drawRectangle(shape);
        } else if(shape.getMType() == 2) {
            drawCircle(shape);
        } else {
            System.out.println("无法判断");
        }
    }

    private void drawRectangle(Shape r) {
        System.out.println("矩形");
    }
    private void drawCircle(Shape c) {
        System.out.println("圆形");
    }
}
