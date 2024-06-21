/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.algebra.model;

import java.awt.Frame;

/**
 *
 * @author andru
 */
public interface ModalWindowCreator <T> {
    void createAndShowModal(Frame parentFrame, T selectedItem);
}
