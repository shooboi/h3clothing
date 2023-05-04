import React from 'react'
import { Fragment } from 'react'
import {
    Button,
    Dialog,
    DialogHeader,
    DialogBody,
    DialogFooter,
} from "@material-tailwind/react";
import { useStateContext } from '../../contexts/StateContext';

const DialogAction = () => {
    const { openDialog, handleOpen } = useStateContext();
    return (
        <Fragment>
            <Dialog open={openDialog} handler={handleOpen}>
                <DialogHeader>Do you want to delete this</DialogHeader>
                <DialogBody divider>
                    {/* Lorem, ipsum dolor sit amet consectetur adipisicing elit. Accusamus ad
                    reprehenderit omnis perspiciatis aut odit! Unde architecto
                    perspiciatis, dolorum dolorem iure quia saepe autem accusamus eum
                    praesentium magni corrupti explicabo! */}
                </DialogBody>
                <DialogFooter>
                    <Button
                        variant="text"
                        color="red"
                        onClick={handleOpen}
                        className="mr-1"
                    >
                        <span>Cancel</span>
                    </Button>
                    <Button variant="gradient" color="green" onClick={() => handleOpen()}>
                        <span>Confim</span>
                    </Button>
                </DialogFooter>
            </Dialog>
        </Fragment>
    )
}

export default DialogAction